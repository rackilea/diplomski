Action[] acts = new Action[n];
for(int i = 0; i < n; i++) {
    if (s.equals("rotate_forw"))
        acts[i].type = ActionType.RotF;
    else if (s.equals("rotate_back"))
        acts[i].type = ActionType.RotB;
    else if (s.equals("shift_forw"))
        acts[i].type = ActionType.ShiftF;
    else if (s.equals("shift_back"))
        acts[i].type = ActionType.ShiftB;
    else
        System.out.println("Incorrect");
}