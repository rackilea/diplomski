<?php while ($data=mysql_fetch_assoc($result)) { ?>
    <option value ="<?php echo $data['ID'] ?>" <?php if($data['ID'] == 'some value') 
        echo( 'selected = "selected"' ); ?> >
        <?php echo $data['Name'] ?>
    </option>
<?php } ?>