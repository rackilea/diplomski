--$(boundary)
Content-Type: application/xml; charset=UTF-8

<?xml version="1.0"?>
<!DOCTYPE pap PUBLIC "-//WAPFORUM//DTD PAP 2.0//EN" 
    "http://www.wapforum.org/DTD/pap_2.0.dtd" 
    [<?wap-pap-ver supported-versions="2.0"?>]>
<pap>
<push-message push-id="$(pushid)" ppg-notify-requested-to="$(notifyURL)">

<address address-value="WAPPUSH=$(pin)%3A100/TYPE=USER@rim.net"/>
<quality-of-service delivery-method="$(deliveryMethod)"/>
</push-message>
</pap>
--$(boundary)
$(headers)

$(content)
--$(boundary)--