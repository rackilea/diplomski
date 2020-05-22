SELECT d.*
FROM data d LEFT JOIN
     data dcars
     ON d.result = dcars.result and
        dcars.company = 'cars'
WHERE d.group = 'ground' and
      dcars.company is null;