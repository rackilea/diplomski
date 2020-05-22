<fx:Script>
    <![CDATA[
        import mx.events.FlexEvent;

        protected function onCreationCompleteHandler(event:FlexEvent):void
        {
            task_list_dg.dataProvider = data..batch;
        }

        private var data:XML = //xml example from server
            <batches>
            <batch>
                <rd>2010-04-23 16:31:00.0</rd>
                <mt>SC1REVISION01</mt>
                <ssd>2010-02-18 00:00:00.0</ssd>
                <sss>100000009</sss>
                <fn>Revision 1-DF-Ocean-SC1SUM-Quanta-PACT-EMEA-Scheduled Ship Date 20100218.csv</fn>
                <bn>10041</bn>
            </batch>
            </batches>;



    ]]>
</fx:Script>

<mx:AdvancedDataGrid id="task_list_dg" width="100%" height="95%" paddingLeft="0" paddingTop="0" paddingBottom="0">
    <mx:columns>
        <mx:AdvancedDataGridColumn headerText="Receiving date" dataField="rd"/>
        <mx:AdvancedDataGridColumn headerText="Msg type" dataField="mt"/>
        <mx:AdvancedDataGridColumn headerText="SSD" dataField="ssd"/>
        <mx:AdvancedDataGridColumn headerText="Shipping site" dataField="sss"/>
        <mx:AdvancedDataGridColumn headerText="File name" dataField="fn"/>
        <mx:AdvancedDataGridColumn headerText="Batch number" dataField="bn"/>
    </mx:columns>
</mx:AdvancedDataGrid>