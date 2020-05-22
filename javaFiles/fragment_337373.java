ViewHolder vh;
if (convertView == null) {
    convertView = mInflater.inflate(R.layout.player_details_row, parent, false);
    vh = new ViewHolder();
    vh.tvRoleSeason = (TextView) convertView.findViewById(R.id.tvRoleSeason);
    vh.tvRoleTeam = (TextView) convertView.findViewById(R.id.tvRoleTeam);
    vh.tvRoleContractType = (TextView) convertView.findViewById(R.id.tvRoleContractType);
     vh.ivTeamLogoImage = (ImageView) convertView.findViewById(R.id.ivTeamLogoImage); 
    convertView.setTag(vh);
    } else {
    vh = (ViewHolder) convertView.getTag();

    }

    PlayerRolesModel item = getItem(position);
    PlayerRolesModelTeam team = item.prmTeam;

    vh.tvRoleSeason.setText(item.startDate.substring(0,3) + "-" + item.endDate.substring(0,3));
    vh.tvRoleTeam.setText(team.prmTeamName);
    vh.tvRoleContractType.setText(item.Type);
    vh.ivTeamLogoImage.setImageResource(R.drawable.ic_launcher);
    return convertView;
    }