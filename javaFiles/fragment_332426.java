# Play 'routes' configuration file…

 # Method   URL path         Controller

GET        /                Application.index
GET        /about           Application.about
POST       /item            Item.addItem
GET        /item/{id}       Item.getItem
GET        /item/{id}.pdf   Item.getItemPdf