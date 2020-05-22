<s:textfield
    id="%{optionId(#attr.option, 'price')}"
    name="%{optionField(#attr.option, 'price')}"
    value="%{optionGrossPrice(#attr.option).getString()}"
    cssClass="input price"
    size="8"
    maxlength="11"
    onchange="%{optionPriceUpdate(#attr.option)}" />