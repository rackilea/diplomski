<logic:present name="BeanKey" property="value(RecordNotFound)">
<logic:equal value="false" name="BeanKey" property="value(RecordNotFound)">
    <script>
        window.onload = function ()
        {
           alert("Record not found");
         }
    </script>
</logic:equal>
</logic:present>