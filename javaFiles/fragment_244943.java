<div>
    <ui:repeat var="deviceSel" value="#{reportViewproto.selectedDevices}" varStatus="loop">
        <h:outputText value="#{deviceSel}" />
        <div id="chartDiv_#{loop.index}" style="width:600px; height:400px;" onclick="Reports_Cap.generateSparkLine('chartDiv_#{loop.index}', 'generateSparkLine')"></div>
        <br />
   </ui:repeat>
</div>