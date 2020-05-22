SELECT *
FROM TABLE_1
WHERE CONCAT(COL_1, ',', COL_2) IN (
    'object_1_val1,object_2_val1',
    'object_1_val2,object_2_val2',
    'object_1_val3,object_2_val3',
    'object_1_val4,object_2_val4',
    ...
);