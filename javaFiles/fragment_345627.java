<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
xmlns:g="urn:import:com.google.gwt.user.client.ui">
<ui:style>
    .important {
        font-weight: bold;
    }
    .header_bar{
        position:absolute;
        top:0px;
        left:0px;
        height: 100px;
        right:0px;
        background-color: red;
    }

    .left_bar{
        position:absolute;
        top:100px;
        left:0px;
        bottom:0px;
        width: 130px;
        background-color: green;
    }

    .menu_bar{
        position:absolute;
        top:100px;
        left:130px;
        height: 30px;
        right:0px;
        background-color: yellow;
    }
    .content{
        position:absolute;
        top:130px;
        left:130px;
        right: 0px;
        bottom: 0px;
    }
</ui:style>
<g:HTMLPanel>
<div class="{style.header_bar}">
    <g:FlowPanel ui:field="headerPanel"></g:FlowPanel> 
</div>
<div class="{style.left_bar}">
    <g:FlowPanel ui:field="leftPanel"></g:FlowPanel>
</div>
<div class="{style.menu_bar}">
    <g:FlowPanel ui:field="menuPanel"></g:FlowPanel>
</div>
<div class="{style.content}">
    <g:FlowPanel ui:field="contentPanel"></g:FlowPanel>
</div>
</g:HTMLPanel>