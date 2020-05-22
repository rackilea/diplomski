function clearNotifications() {
    $.ajax({
        type: "POST",
        url: "/clearNotifications/" + $ {
          bike.id
        },
        headers: {
          "Accept": "text/html,application/json"
        },
        success: function(result) {
          //$("#notifications").html(result);
          alerts = result;
          populateNotification(alerts);
        }
      }
    });
</script>