<c:when test="#{item.type eq 'DYNAMIC'}">
    <ds:Dynamic id="dynamic_#{status.index}"
        updateAction="#{cc.attrs.update}"
        dynamicItem="#{item}"
        onstart="#{cc.attrs.onstart}"
        oncomplete="#{cc.attrs.oncomplete}"/>
</c:when>