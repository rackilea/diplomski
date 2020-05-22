declare
   new_id number; --or your id row type
begin
        insert into Persons  
           (Id,First_Name,Last_Name)  
           values (person_seq.nextval  ,?  ,?  )
           returning id into new_id;
        insert into Relations (relation_id, person_id) 
            values (relation_seq.nextval,person_seq.currval); 
end;