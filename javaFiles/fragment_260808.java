employeeBatchDao.deleteEmployeeImportedData(employeeId);

<delete id="deleteEmployeeImportedData" parameterType="Integer">
   {call
       declare
       begin
           DELETE FROM TABLE1 WHERE ID = :id AND CREATION_DATE IS NULL;
           DELETE FROM TABLE2 WHERE ID = :id AND CREATION_DATE IS NULL;
       end
    }