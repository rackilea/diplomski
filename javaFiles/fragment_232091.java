CREATE OR REPLACE TYPE challan_rec IS OBJECT
(
   challan_number VARCHAR2 (40),
   challan_amount NUMBER
);
/    
CREATE OR REPLACE Type rec is table of challan_rec;
/ 
 CREATE OR REPLACE FUNCTION get_challan(foo number) 
    return rec
  is  
    cr rec:=rec();

   begin
        cr.extend();
        cr(1):= challan_rec('00002154215',foo);        
        return cr;
   end get_challan;   
end;

/