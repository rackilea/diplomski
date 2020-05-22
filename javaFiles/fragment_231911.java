<s:HTTPService id="service" url="Srvlt" result="resultHandler(event)"
fault="faultHandler(event)" method="GET" showBusyCursor="true" resultFormat="text">
    <s:request xmlns="">
        <email>{email.text}</email>
        <pass>{pass.text}</pass>
    </s:request>
</s:HTTPService>