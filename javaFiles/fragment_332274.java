/**
** This will load the product attributes. Now you can create a plugin to do this which will 
**help with performance however in my case the plugin was not working correctly.
**/

    <?php $_product= Mage::getSingleton('catalog/product')->load($_item->getProductId()) ?> 



/**
**Use javascript to add the attribute into the correct location in the shopping cart.
**
**/

<script>

 var elements = document.getElementsByClassName('item-options'), last = elements.length - 1;

 elements[last].innerHTML = "<dt>Odkaz </dt><dd>Instalační soubor</dd>   <dt>No Of Devices:</dt> <dd><?php echo $_product->getResource()->getAttribute('number_of_devices')->getFrontend()->getValue($_product); ?></dd>  <dt>License Period:</dt> <dd><?php echo $_product->getResource()->getAttribute('licence_period')->getFrontend()->getValue($_product); ?></dd> ";
</script>