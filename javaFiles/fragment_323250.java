INSERT INTO operation ( 
  phone_number,
  age,
  gender,
  isActive,
  date_of_surgery
) SELECT 
  'some-phone-' || round(random()*1000), -- for text
  round(random()*70), -- for integer
  (ARRAY['f','m'])[round(random())+1], -- for char/enum
  (ARRAY[false,true])[round(random())+1], -- for boolean
  now() + round(random()*1000) * '1 second'::interval -- for timestamps
FROM generate_series(1,10000);