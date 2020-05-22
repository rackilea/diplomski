function getCode(intVal1, intVal2, intVal3, IntA) {
    var intVal5 = intVal2 ^ intVal3;
    intVal5 = intVal5 + (intVal1 | IntA) | 0;
    intVal5 = Math.imul(intVal5, (intVal1 | intVal3));
    intVal5 = Math.imul(intVal5, (intVal2 ^ IntA));
    return intVal5;
}
alert(getCode(1747, 1763, -268087281, 348400));