<endpoint address="http://localhost:8080/SecureCalculatorApp/CalculatorWSService"
          binding="customBinding" bindingConfiguration="CalculatorWSPortBinding1"
          contract="ServiceReference3.CalculatorWS" name="CalculatorWSPort1">
        <identity>
          <dns value="{YOUR ALIAS}" />
        </identity>
      </endpoint>