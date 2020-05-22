$('#parentCategorySelector').change(function () {
            var selectedValue = this.value;
             if (selectedValue == '--Select a parent category--') {
                $('#categorySelector').empty();
            } else {
                $.post('${PREFIX}/category', {parentCategory:selectedValue}, function(data) {
                    $('#categorySelector').empty();
                    $.each(data.categorySelectorList, function(key, value) {
                        $('#categorySelector').append($('<option/>', {
                            value : value['id'],
                            text : value['category']
                        }));
                    });

                }, 'json');
            }

        });