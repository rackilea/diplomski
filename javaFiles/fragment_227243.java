@(elements: helper.FieldElements)

<div class="@if(elements.hasErrors) {error}">
    <div class="input">
        @elements.input
        <span class="errors">@elements.errors.mkString(", ")</span>
        <span class="help">@elements.infos.mkString(", ")</span> 
    </div>
</div>