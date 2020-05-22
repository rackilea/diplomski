select argument_name,  data_type, in_out
from user_arguments
where package_name is null
and object_name = 'TEST'
order by subprogram_id, position;

ARGUMENT_NAME                  DATA_TYPE                      IN_OUT  
------------------------------ ------------------------------ ---------
ECM_PROPERTY                   REF CURSOR                     OUT       
P_RETURN_VALUE                 NUMBER                         OUT       
P_ERROR_MESSAGE                VARCHAR2                       OUT