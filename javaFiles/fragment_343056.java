@Property
private ScanMode scanMode

public ScanMode getRecto(){ return ScanMode.RECTO; }
public ScanMode getRectoVerso(){ return ScanMode.RECTO_VERSO; }


<t:radiogroup t:value="scanMode" >
    <t:label for="recto">Recto</t:label>
    <t:radio t:id="recto"/>
    <br />
    <t:label for="rectoVerso">Recto/Verso</t:label>
    <t:radio t:id="rectoVerso"/>
</t:radiogroup>