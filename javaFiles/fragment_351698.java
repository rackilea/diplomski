public ListNode addListF(ListNode l1, ListNode l2, CarryWrap carry) {

    /**same statement before recursive call**/

    result.next = addListF(l1.next, l2.next, carry);
    int sum = carry.value + l1.data + l2.data;
    result.data = sum % 10;
    carry.value = sum / 10;

    return result;
}