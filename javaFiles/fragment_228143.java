public static void jump(int[] world) {
    for (int fromIndex = 0; fromIndex < world.length; fromIndex++) { // index of pad to jump from
        // any frog/s here?
        int frogsJumping = world[fromIndex];
        if (frogsJumping > 0) {
            // try to jump left; frogsJumping frogs jump frogsJumping places
            int targetIndex = fromIndex - frogsJumping;
            if (targetIndex >= 0 && world[targetIndex] > 0) { // must not jump to empty pad
                performJump(fromIndex, targetIndex, world, frogsJumping);
            }
            // try a right jump
            targetIndex = fromIndex + frogsJumping;
            if (targetIndex < world.length && world[targetIndex] > 0) {
                performJump(fromIndex, targetIndex, world, frogsJumping);
            }
        }
    }
}

private static void performJump(int fromIndex, int toIndex, int[] world, int frogsJumping) {
    solution.push(new Jump(frogsJumping, fromIndex, toIndex));
    world[fromIndex] = 0;
    world[toIndex] += frogsJumping;
    if (world[toIndex] == noOfFrogs) {
        System.out.println("Solved: " + Arrays.toString(world));
        System.exit(0);
    }
    jump(world);
    // backtrack
    world[toIndex] -= frogsJumping;
    world[fromIndex] = frogsJumping;
    solution.pop();
}