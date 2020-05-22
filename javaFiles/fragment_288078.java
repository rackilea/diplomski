const express = require('express');
const morgan = require('morgan');
const routes = require('./routes/customer.routes')

const app = express();

//Settings
app.set('appName', 'API for Java');
app.set('port', process.env.PORT || 5000);

//Middlewares
app.use(morgan('combine'));
app.use(express.json())


// Routes
app.use('/api-java',routes);
app.get('/login', (req, res) => res.send('Hello desde login'))


// Start Server
app.listen(app.get('port'), () => {
  console.log('Server running on port:', app.get('port'));
  console.log(app.get('appName'))
})