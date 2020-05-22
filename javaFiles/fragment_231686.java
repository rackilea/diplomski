const express = require('express')
const proxy = require('http-proxy-middleware')
const path = require('path')
const app = express()

const port = process.argv[2] || 9999
const cmsPort = 8080

// CMS webapp
app.use('/cms',
    proxy({
        target: `http://localhost:${cmsPort}`,
        changeOrigin: false
    })
)

// Website
app.use('/', 
    proxy({
        target: `http://localhost:${cmsPort}/site`,
        pathRewrite: {
            '^/site/': '/'
        },
        ws: true,
        changeOrigin: true
    })
)

app.listen(port)
console.log(`Listening on port ${port} ...`)