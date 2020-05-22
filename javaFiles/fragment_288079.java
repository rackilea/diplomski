const express = require('express');
const router = express.Router();

router.get('/', (req, res) => res.send('GET Response'))

router.put('/put', (req, res) => {
  const { adq, cnpj, blockcode } = req.body;

  console.log(req.body)
  res.json({
    adq : adq , cnpj, blockcode
  })
})

module.exports = router;