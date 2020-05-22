%dw 1.0
%output application/java
%var skuLookup = {(flowVars.SSRCreateStarshipItems map {
    ($.sku) : $.qty
})}
---
flowVars.SSRGetOrderItems map {
    ($.itemid) : skuLookup[$.sku]
}