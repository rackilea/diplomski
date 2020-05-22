package com.app.apti.adapter;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.apti.R;
import com.app.apti.model.QuestionData;

import java.util.ArrayList;


public class QuestionViewPager extends PagerAdapter {

private Context context;
ArrayList<QuestionData> question;
LayoutInflater layoutInflater;
ImageView imageView;
String category;

public QuestionViewPager(Context context, ArrayList<QuestionData> 
question,String category)
{
    this.context=context;
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.question=question;
    this.category=category;
}

@Override
public int getCount() {
    if(question != null){
        return question.size();
    }
    return 0;
}

@Override
public boolean isViewFromObject(View view, Object object) {
    return view == ((LinearLayout) object);
}

@Override
public int getItemPosition(Object object) {
    return POSITION_NONE;
}

@Override
public Object instantiateItem(ViewGroup container, final int position) {
    /* ALL LOCAL VARIABLES */
    LinearLayout option1color,option2color,option3color,option4color;
    TextView option1,option2,option3,option4,ques,questionno;

    View itemView = layoutInflater.inflate(R.layout.questionlayout, container, false);
    option1color=(LinearLayout)itemView.findViewWithTag(R.id.color_option1);
    option2color=(LinearLayout)itemView.findViewById(R.id.color_option2);
    option3color=(LinearLayout)itemView.findViewById(R.id.color_option3);
    option4color=(LinearLayout)itemView.findViewById(R.id.color_option4);

    option1=(TextView)itemView.findViewById(R.id.option1);
    option2=(TextView)itemView.findViewById(R.id.option2);
    option3=(TextView)itemView.findViewById(R.id.option3);
    option4=(TextView)itemView.findViewById(R.id.option4);
    ques=(TextView)itemView.findViewById(R.id.ques);
    questionno=(TextView)itemView.findViewById(R.id.questionno);

    questionno.setText(position+1+"/"+getCount());
    ques.setText(Html.fromHtml(question.get(position).getQues()));
    option1.setText(Html.fromHtml(question.get(position).getOpt1()));
    option2.setText(Html.fromHtml(question.get(position).getOpt2()));
    option3.setText(Html.fromHtml(question.get(position).getOpt3()));
    option4.setText(Html.fromHtml(question.get(position).getOpt4()));

    option1color.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context,option1.getText().toString(),Toast.LENGTH_SHORT).show();
            if(question.get(position).getAns().equalsIgnoreCase(option1.getText().toString()))
            {

                option1color.setBackgroundResource(R.drawable.round_corner_green);
            }else
            {
                option1color.setBackgroundResource(R.drawable.round_corner_red);

            }
        }
    });
    option2color.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(question.get(position).getAns().equalsIgnoreCase(option2.getText().toString()))
            {
                option2color.setBackgroundResource(R.drawable.round_corner_green);
            }else
            {
                option2color.setBackgroundResource(R.drawable.round_corner_red);

            }
        }
    });
    option3color.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(question.get(position).getAns().equalsIgnoreCase(option3.getText().toString()))
            {
                option3color.setBackgroundResource(R.drawable.round_corner_green);
            }else
            {
                option3color.setBackgroundResource(R.drawable.round_corner_red);

            }
        }
    });
    option4color.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(question.get(position).getAns().equalsIgnoreCase(option4.getText().toString()))
            {
                option4color.setBackgroundResource(R.drawable.round_corner_green);
            }else
            {
                option4color.setBackgroundResource(R.drawable.round_corner_red);

            }
        }
    });

    container.addView(itemView);

    return itemView;
}

@Override
public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((LinearLayout) object);
}



}