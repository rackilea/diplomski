%dw 1.0
%output application/java
---
flowVars.input2 map {
    serialNumber : $.serialNumber,
    maintenanceId: $.maintenanceId,
    customerID: $.customerID,
    startDate: $.startDate,
    endDate: $.endDate,
    status: "deactivated" when $.endDate as :date {format:"yyyy-M-dd HH:mm:ss"} > (now  as :date {format:"yyyy-M-dd HH:mm:ss"}) otherwise "activated"
}