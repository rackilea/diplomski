<ui:style>
    .empty {
        width: 100%;
        line-height: 96px;
        font-size: 16px;
        text-align: center;
    }
</ui:style> 

<g:HTMLPanel>

    <h2 class="sides">My Favorites</h2>

    <div ui:field="emptyLabel" class="{style.empty}" >You have no favorites at this time.</>

    <g:FlowPanel ui:field="container" addStyleNames="row flex-wrap" />

</g:HTMLPanel>