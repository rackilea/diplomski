<ul class="rich-datalist">
    <a4j:repeat value="#{list}" var="item">
        <h:panelGroup rendered="#{item.somecondition}">
            <li class="rich-list-item">
                <h:outputText value="#{item.something}" />
            </li>
        </h:panelGroup>
    </a4j:repeat>
</ul>