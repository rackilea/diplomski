aux = {
                    'location_id' : location['id'],
                    'name' : location['name'] or " ",
                    'units' : location['units'] or 0.0,
                    'area' : location['area'] or 0.0,
                    'day_meter' : location['day_meter'] or 0.0,
                    'free' : location['free'] or 0.0,    
                    'type' : location['type'] or " ",
                    'loc_type' : location['loc_type'] or " ",
                    'image' : base64.b64encode(str(location['image'])),                                                                    
               }