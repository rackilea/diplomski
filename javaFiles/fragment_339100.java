<?php
require_once 'PHPUnit/Framework.php';
// require the file containing the class that sodaVendor is an instance of

define('SODA_PRICE', 75);

class SodaVendorTest extends PHPUnit_Framework_TestCase {
    private $sodaVendor;

    public function setUp() {
        // set up $this->sodaVendor somehow...
    }

    public function tearDown() {
        $this->sodaVendor = null;
    }

    public function testBalanceReturnsToZeroOnVending() {
        $this->sodaVendor->insertCoin(50);
        $this->sodaVendor->insertCoin(20);
        $this->sodaVendor->insertCoin(5);
        // The price is right!
        $this->assertEquals(SODA_PRICE,
            $this->sodaVendor->getCurrentBalance(),
            "We have entered correct money");
        $this->sodaVendor->dispenseItem();
        $this->assertEquals(0,
            $this->sodaVendor->getCurrentBalance(),
            "After vending, the balance of soda vending machine is zero");
    }
}
?>