<form:FieldLabel text="{constants.typ}" labelAlign="TOP">
    <form:widget>
        <g:HorizontalPanel>
          <g:ComboBox ui:field="type" width="300" allowBlank="true" forceSelection="true" triggerAction="ALL" />
          <g:Image resource="{loadingGif}" ui:field="Monimage" />
        </g:HorizontalPanel>
    </form:widget>
</form:FieldLabel>