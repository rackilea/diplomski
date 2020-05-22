SELECT rdo_code, batch_no, reference_no, dln, retrn_seq_num, ftype_code, tin, 
    branch_code, tax_type
       , max(retrn_period) as retrn_period
       , max(version) as version
FROM   rfp_returns_ref 
WHERE  tin = '000079108' 
AND    ftype_code = '1702EX' 
AND    Upper(status) = Upper('POSTED') 
group by rdo_code, batch_no,reference_no, dln, 
    retrn_seq_num, ftype_code, tin, branch_code, tax_type;