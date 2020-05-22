jQuery("#advanced-search").submit(function(e){
            //var formInput=jQuery(this).serializeObject();
            var formInput=jQuery(this).serializeJSON({parseBooleans: true,parseNulls: true});

            e.preventDefault();
            jQuery.ajax({
                url: "<s:url action='searchJSON'/>",
                data: "jsonForm="+JSON.stringify(formInput),
                contentType: "application/json",
                dataType: "json"
            }).done(function( msg ) {
                window.location.href="<s:url action='search'/>?"+msg;
            });
        });