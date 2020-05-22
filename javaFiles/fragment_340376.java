<ui:repeat value="#{paymentDetailsBean.products}" var="product">
    <li>
        <div>
            <h:selectBooleanCheckbox>
                <f:ajax render=":paymentDetailsForm:totalPriceText" 
                        listener="#{paymentDetailsBean.updateTotalPrice(product, component.value)}" />
            </h:selectBooleanCheckbox>
        </div>
    </li>
</ui:repeat>
<h:outputText value="#{paymentDetailsBean.totalPrice}" />