<script>
    function categoryDropDownEditor(container, options) {
        $('<input data-text-field="categoryName" data-value-field="categoryId" data-bind="value:' + options.field + '"/>')
        .appendTo(container)
        .kendoDropDownList({
            autoBind: false,
            dataSource: {                
                transport: {
                    read: "${categoriesUrl}"
                }
            }
        });
    }
</script>