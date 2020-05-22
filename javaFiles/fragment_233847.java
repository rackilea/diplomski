<container:VerticalLayoutContainer addStyleNames="{mystyle}">
  <form:FieldLabel text="{constants.typ}" labelAlign="TOP">
    <form:widget>

      <g:HTMLPanel>
      <!--
        Here, I can now place plain old HTML :) 
        Let's place the 2 components via 2 divs and a float:left.
      -->
        <div style="float:left">
          <form:ComboBox ui:field="type" width="300" allowBlank="true" forceSelection="true" triggerAction="ALL" />
        </div>
        <div>
          <g:Image resource="{loadingGif}" ui:field="Monimage" />                                          
        </div>
      </g:HTMLPanel>

    </form:widget>
  </form:FieldLabel>
</container:VerticalLayoutContainer>