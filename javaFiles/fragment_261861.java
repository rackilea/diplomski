<ui:define name="content">
    <script>
        jQuery(document).ready(function() {
            var selected = document.getElementById("page1Form:hiddenId").value;
            if(selected != -1) {
                document.getElementById("page1Form:typeTable:" + selected + ":chkType").checked = true;
            }
        });
    </script>