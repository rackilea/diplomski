final int space = 6 - usedWithAmount;
if (itemAmount < space) {
  amountToTransfer = itemAmount;
} else {
  amountToTransfer = space;
}