mClickedPosition = position;
  String temp[] = m_listItems.get(position).split("\\s\\s+");
  result = temp[temp.length - 1].trim();
  result = result.replace("RM","");
  name = temp[1].trim();
  if (name.equals("Project")) {


                Intent intent = new Intent(Claims1.this.getActivity(), Project1.class);
                intent.putExtra("bitmap", true);
                intent.putExtra("name", name);
                intent.putExtra("result", result);
                startActivityForResult(intent, 0);
                Log.e("RESULT", "Result= " + result);
            }
            else if(name.equals("Medical"))
            {
                Intent intent = new Intent(Claims1.this.getActivity(), Medical.class);
                intent.putExtra("bitmap", true);
                intent.putExtra("name", name);
                intent.putExtra("result", result);
                startActivityForResult(intent, 1);
            }