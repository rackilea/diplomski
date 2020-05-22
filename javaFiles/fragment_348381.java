1st step, POST
{"name": "MyFirstProduct"}

2nd step POST to create squad
{"name": "MyFirstSquad"}

3rd step PATCH created squad (alter it) - request PATCH http://localhost:8080/squad/1 - assuming it was created with id 1
{"name": "MyFirstSquad", "product":["http://localhost:8080/products/1"]} - assuming the product was created with id 1.