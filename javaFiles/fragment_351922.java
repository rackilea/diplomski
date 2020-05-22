> db.runCommand({geoNear: "places",
                 near: { type: "Point", 
                         coordinates: [ 39.904522, 116.65588 ] 
                       },
                 spherical: true    
});

{
  "ok": 0,
  "errmsg": "'near' field must be point",
  "code": 17304,
  "codeName": "Location17304"
}