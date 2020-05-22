// config/index.js
module.exports = {
  // ...
  dev: {
    proxyTable: {
      // proxy all requests starting with /api to jsonplaceholder
      '/api': {
        target: 'http://jsonplaceholder.typicode.com:8000', // <-- Spring app running here
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}