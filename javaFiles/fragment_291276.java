do {
    var currNode = root
    var maxChild = if (currNode.left.value > currNode.right.value) currNode.left else currNode.right

    if (currNode.value < maxChild.value) {
        val tempValue = currNode.value
        currNode.value = maxChild.value
        maxChild.value = tempValue

        currNode = maxChild
    } else {
        break
    }
} while (true)