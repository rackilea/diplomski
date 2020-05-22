<?php
$rows = array(
    "ans" => "JAN,FEB,MAR"
);
?>
<html>
<body>
<script type="text/javascript">
    var test = [<?php echo '"'. implode('","',explode(",",$rows['ans'])) . '"'; ?>];
    document.write(test.toString());
</script>
</body>
</html>