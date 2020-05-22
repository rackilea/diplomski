con.createStatement().execute("DROP TRIGGER IF EXISTS `insert_associated_inquiry`");

triggerBuilder.append(" CREATE TRIGGER insert_associated_inquiry BEFORE UPDATE ON inquiry ");
triggerBuilder.append(" FOR EACH ROW Begin ");    

triggerBuilder.append(" insert into associated_inquiries(inquiry_id , subject , content , inquiry_date , preferred_date ) " );
triggerBuilder.append("values");
        triggerBuilder.append(" ( " );
            triggerBuilder.append(" OLD.id , ");
            triggerBuilder.append(" OLD.subject , " );
            triggerBuilder.append(" OLD.content , " );
            triggerBuilder.append(" OLD.created_on , " );
            triggerBuilder.append(" OLD.preffered_date " );
        triggerBuilder.append(" ) ; ");

triggerBuilder.append(" END ");

con.createStatement().execute(triggerBuilder.toString());