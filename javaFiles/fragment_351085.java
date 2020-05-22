String stat;
StringBuffer utilOutput = new StringBuffer();
while((stat = input.readLine()) != null){
    utilOutput.append(stat + "\n");
}
req.setAttribute("utilOutput", utilOutput.toString());
req.getRequestDispatcher("/Example/status.jsp").forward(req, res);