function chooseChair() {
            var chairNum = [];
            $('.check:checked').each(function() {
                chairNum.push($(this).val());
            })
            var busId = $('.checkId').val();
            var reserv = {
                           chairNumber: chairNum,
                           busId : busId
                         }
            alert(chairNum);
            alert(busId);
            $.ajax({
                type : "POST",
                url : "http://localhost:8080/spr-data/searchChair",
                data : reserv
            }).done(function(data) {
                alert(JSON.stringify(data));
            })
        }