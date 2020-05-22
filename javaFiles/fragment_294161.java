SELECT rdo_code, batch_no, reference_no, dln, retrn_seq_num, ftype_code, tin, 
    branch_code, tax_type
       , retrn_period
       , version
FROM   rfp_returns_ref 
WHERE  tin = '000079108' 
AND    ftype_code = '1702EX' 
AND   order by version desc 
fetch first 1 row only;